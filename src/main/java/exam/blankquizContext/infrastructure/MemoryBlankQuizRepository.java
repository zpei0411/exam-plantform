package exam.blankquizContext.infrastructure;

import org.springframework.stereotype.Component;

import exam.blankquizContext.domain.blankQuiz.BlankQuiz;
import exam.blankquizContext.domain.blankQuiz.BlankQuizId;
import exam.blankquizContext.domain.blankQuiz.BlankQuizRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
  private Set<BlankQuiz> blankQuizzes = new HashSet<>();

  @Override
  public BlankQuiz find(BlankQuizId blankQuizId) {
    return blankQuizzes.stream().filter(blankQuiz -> {
      return blankQuiz.getBlankQuizId().equals(blankQuizId);
    }).findFirst().orElseThrow(NullPointerException::new);
  }

  @Override
  public void save(BlankQuiz blankQuiz) {
    blankQuizzes.add(blankQuiz);
  }

  @Override
  public void remove(BlankQuiz blankQuiz) {
    blankQuizzes.remove(blankQuiz);
  }

  @Override
  public List<BlankQuiz> getAll() {
    return blankQuizzes.stream().collect(Collectors.toList());
  }

  @Override
  public BlankQuizId nextBlankQuizId() {
    return new BlankQuizId();
  }

}