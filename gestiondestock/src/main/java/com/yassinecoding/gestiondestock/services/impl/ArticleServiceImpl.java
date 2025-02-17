package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.ArticleDto;
import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import com.yassinecoding.gestiondestock.model.Article;
import com.yassinecoding.gestiondestock.repository.ArticleRepository;
import com.yassinecoding.gestiondestock.services.ArticleService;
import com.yassinecoding.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
//s a Lombok annotation that automatically generates a logger field in the class.
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    // inject the ArticleRepository into the ArticleServiceImpl class

     private ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @Override
    public ArticleDto save(ArticleDto dto) {
        // verification of the validity of the article
        List<String> errors = ArticleValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Article n'est pas valid", dto);
            throw new InvalidEntityException("l'article n'est pas valid", ErrorCode.ARTICLE_NOT_VALID, errors);
        }
        // save the article
        return ArticleDto.fromEntity(
                articleRepository.save(ArticleDto.toEntity(dto))
        );

    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }
        Optional<Article> articleOptional = articleRepository.findArticleById(id);
        return articleOptional
                .map(ArticleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n'a été trouvé dans la BDD",
                        ErrorCode.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (codeArticle == null) {
            log.error("Article Code is null");
            return null;
        }
        Optional<Article> articleOptional = articleRepository.findArticleByCodeArticle(codeArticle);
        return articleOptional
                .map(ArticleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun article avec Code article  = " + codeArticle + " n'a été trouvé dans la BDD",
                        ErrorCode.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteArticle(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }
        articleRepository.deleteById(id);

    }
}
