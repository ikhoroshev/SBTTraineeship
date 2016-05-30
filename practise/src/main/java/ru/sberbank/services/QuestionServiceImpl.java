//package ru.sberbank.services;
//
//import org.springframework.stereotype.Service;
//import ru.sberbank.model.Question;
//import ru.sberbank.model.TestChapter;
//import ru.sberbank.repositories.QuestionRepository;
//
//import javax.annotation.Resource;
//import java.util.Collection;
//import java.util.HashSet;
//
//@Service
//public class QuestionServiceImpl implements QuestionService {
//    @Resource
//    private QuestionRepository questionRepository;
//
//    private Iterable<Question> findQuestionByTextLikeAndTestChapter(String text, TestChapter testChapter) {
//        if(testChapter==null)
//            return questionRepository.findQuestionByTextLike('%'+text+'%');
//        else return questionRepository.findQuestionByTextLikeAndTestChapterTitle('%'+text+'%', testChapter.getTitle());
//    }
//
//    @Override
//    public Iterable<Question> findQuestionByKeywordsAndTestChapter(String keywords, TestChapter testChapter) {
//        HashSet<Question> result=new HashSet<>();
//        String[] keyword = keywords.split("\\W+");
//        for(String str : keyword){
//            Iterable<Question> questionByTextLikeAndTestChapter = findQuestionByTextLikeAndTestChapter(str, testChapter);
//            result.addAll((Collection<? extends Question>) questionByTextLikeAndTestChapter);
//        }
//
//        return result;
//    }
//
//
//    @Override
//    public void addQuestion(Question question) {
//        questionRepository.save(question);
//    }
//
//    @Override
//    public void deleteQuestion(Long id) {
//        questionRepository.delete(id);
//    }
//
//    @Override
//    public Question findQuestionByID(Long id) {
//        return questionRepository.findOne(id);
//    }
//}

package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.Question;
import ru.sberbank.model.TestChapter;
import ru.sberbank.repositories.QuestionRepository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionRepository questionRepository;

    private Iterable<Question> findQuestionByTextLikeAndTestChapter(String text, TestChapter testChapter) {
        if(testChapter==null)
            return questionRepository.findQuestionByTextLike('%'+text+'%');
        else return questionRepository.findQuestionByTextLikeAndTestChapterTitle('%'+text+'%', testChapter.getTitle());
    }

    @Override
    public Iterable<Question> findQuestionByKeywordsAndTestChapter(String keywords, TestChapter testChapter) {
        HashSet<Question> result=new HashSet<>();
        String[] keyword = keywords.split("\\W+");
        for(String str : keyword){
            Iterable<Question> questionByTextLikeAndTestChapter = findQuestionByTextLikeAndTestChapter(str, testChapter);
            result.addAll((Collection<? extends Question>) questionByTextLikeAndTestChapter);
        }

        return result;
    }


    @Override
    public void addQuestion(Question question) { questionRepository.save(question); }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.delete(id);
    }

    @Override
    public Question findQuestionByID(Long id) {
        return questionRepository.findOne(id);
    }

    @Override
    public Question findQuestionByText(String text) { return questionRepository.findByText(text); }

    @Override
    public Iterable<Question> getAllQuestion() {
        return questionRepository.findAll();
    }
}

