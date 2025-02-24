package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.LigneVenteDto;
import com.yassinecoding.gestiondestock.dto.VentsDto;
import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import com.yassinecoding.gestiondestock.model.Article;
import com.yassinecoding.gestiondestock.model.LigneVente;
import com.yassinecoding.gestiondestock.model.Vents;
import com.yassinecoding.gestiondestock.repository.ArticleRepository;
import com.yassinecoding.gestiondestock.repository.LigneVents;
import com.yassinecoding.gestiondestock.repository.VenteRepository;
import com.yassinecoding.gestiondestock.services.VentsService;
import com.yassinecoding.gestiondestock.validator.VentsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j

public class VentsServiceImpl implements VentsService {

    private VenteRepository venteRepository;
    private ArticleRepository articleRepository;
    private LigneVents ligneVents;
    @Autowired
    public VentsServiceImpl(VenteRepository venteRepository, ArticleRepository articleRepository, LigneVents ligneVents) {
        this.venteRepository = venteRepository;
        this.articleRepository = articleRepository;
        this.ligneVents = ligneVents;

    }

    @Override
    public VentsDto save(VentsDto dto) {
        List<String> errors = VentsValidator.validate(dto);

        // Validate the DTO
        if (!errors.isEmpty()) {
            log.error("Vente is not valid {}", dto);
            throw new InvalidEntityException("La vente n'est pas valide", ErrorCode.VENTES_NOT_VALID, errors);
        }

        // Verify ligne commande and creat list of article Errors
        List<String> articleErrors = new ArrayList<>();

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            // Verify if the article exists
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Article with ID " + ligneVenteDto.getArticle().getId() + " not found");
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("Article is not found in the DB {}", articleErrors);
            throw new InvalidEntityException("Article n'est pas valide", ErrorCode.ARTICLE_NOT_VALID, articleErrors);
        }

        // Save vente
        Vents saveVente = venteRepository.save(VentsDto.toEntity(dto));
        dto.getLigneVentes().forEach(ligneVenteDto1 -> {
            LigneVente ligneVents1 = LigneVenteDto.toEntity(ligneVenteDto1);
            ligneVents1.setVente(saveVente);
            ligneVents.save(ligneVents1);
        });

        return VentsDto.fromEntity(saveVente);
    }

    @Override
    public VentsDto findById(Integer id) {
        if (id == null) {
            log.error("Vents ID is NULL");
            return null;
        }

        Optional<Vents> ventsOptional = venteRepository.findById(id);

        return ventsOptional
                .map(VentsDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente avec l'ID = " + id + " n'a été trouvée dans la BDD",
                        ErrorCode.VENTES_NOT_FOUND
                ));
    }


    @Override
    public VentsDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Your code is empty");
            return null;
        }

        Optional<Vents> ventsOptional = venteRepository.findVentsByCode(code);

        return ventsOptional.map(VentsDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun Vent with this code: " + code + " in this database",
                        ErrorCode.VENTES_NOT_FOUND
                ));
    }

    @Override
    public List<VentsDto> findAll() {

        return venteRepository.findAll().stream().map(VentsDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id ==null){
            log.error("Your id is Null");
            return;
        }

        venteRepository.deleteById(id);

    }
}
