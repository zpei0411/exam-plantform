package exam.blankquizContext.domain.model.blankquiz;

import java.time.LocalDateTime;

import exam.blankquizContext.domain.shared.Entity;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(of = { "blankQuizId" })

public class BlankQuiz implements Entity<BlankQuiz> {
  private BlankQuizId blankQuizId;
  private String teacherId;
  private String content;
  private Integer score;
  private String referenceAnswer;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

  @Override
  public boolean sameIdentityAs(BlankQuiz other) {
    // TODO Auto-generated method stub
    return false;
  }

  public static BlankQuiz create(final String teacherId, final String content, final Integer score,
      final String referenceAnswer) throws IllegalScoreException {
    if (score > 100 || score <= 0) {
      throw new IllegalScoreException(score);
    }
    return BlankQuiz.builder().blankQuizId(BlankQuizId.generate()).teacherId(teacherId).content(content).score(score)
        .referenceAnswer(referenceAnswer).build();

  }

  public static BlankQuiz update(final BlankQuizId id, final String teacherId, final String content,
      final Integer score, final String referenceAnswer) throws IllegalScoreException {
    return BlankQuiz.builder().blankQuizId(id).teacherId(teacherId).content(content).score(score)
        .referenceAnswer(referenceAnswer).build();

  }

  public Object getId() {
    return null;
  }
}