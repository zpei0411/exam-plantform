package exam.blankquizContext.application;

import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository;

public class BlankQuizApplicationService {
  private BlankQuizRepository blankQuizRepository;

  public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
    this.blankQuizRepository = blankQuizRepository;
  }

  public BlankQuizId createQuiz(final CreateQuiz createQuiz) throws IllegalScoreException {
    var blankQuiz = BlankQuiz.create(createQuiz.getTeacherId(), createQuiz.getContent(), createQuiz.getScore(),
        createQuiz.getReferenceAnswer());
    blankQuizRepository.save(blankQuiz);
    return blankQuiz.getId();
  }

  public BlankQuizId updateQuiz(final String quizId, final UpdateQuiz updateQuiz) {
    var blankQuiz = blankQuizRepository.find(new BlankQuizId());
    var newBlankQuiz = blankQuiz.update(new BlankQuizId(quizId), updateQuiz.getTeacherId(), updateQuiz.getContent(),
        updateQuiz.getScore(), updateQuiz.getReferenceAnswer());
    blankQuizRepository.save(newBlankQuiz);
    return newBlankQuiz.getId();
  }

  public void deleteQuiz(final DeleteQuiz deleteQuiz) {
    blankQuizRepository.delete(new BlankQuizId(deleteQuiz.getQuizId()));
  }
}