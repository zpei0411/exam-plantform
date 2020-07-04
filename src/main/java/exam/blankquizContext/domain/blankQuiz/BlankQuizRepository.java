package exam.blankquizContext.domain.blankQuiz;

import java.util.List;

public interface BlankQuizRepository {
  void save(BlankQuiz blankQuiz);

  void remove(BlankQuiz blankQuiz);

  BlankQuiz find(BlankQuizId blankQuizId);

  List<BlankQuiz> getAll();

  BlankQuizId nextBlankQuizId();
}