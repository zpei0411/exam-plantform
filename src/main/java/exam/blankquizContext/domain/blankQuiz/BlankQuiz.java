package exam.blankquizContext.domain.blankQuiz;

import java.time.LocalDateTime;

import exam.blankquizContext.domain.shared.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = { "blankQuizId" })
@Getter
public class BlankQuiz implements Entity<BlankQuiz> {
  private BlankQuizId blankQuizId;
  private String content;
  private String referenceAnswer;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  private LocalDateTime removeTime;

  private BlankQuiz(BlankQuizId blankQuizId, String content, String referenceAnswer) {
    this.blankQuizId = blankQuizId;
    this.content = content;
    this.referenceAnswer = referenceAnswer;
    createTime = LocalDateTime.now();
  }

  public static BlankQuiz create(BlankQuizId blankQuizId, String content, String referenceAnswer) {
    return new BlankQuiz(blankQuizId, content, referenceAnswer);
  }

  public void revise(String teacherId, String content, String referenceAnswer, int score) {
    this.content = content;
    this.referenceAnswer = referenceAnswer;
    this.updateTime = LocalDateTime.now();
  }

  @Override
  public boolean sameIdentityAs(BlankQuiz other) {
    return blankQuizId.sameValueAs(other.getBlankQuizId());
  }

  public BlankQuizId getBlankQuizId() {
    return blankQuizId;
  }
}