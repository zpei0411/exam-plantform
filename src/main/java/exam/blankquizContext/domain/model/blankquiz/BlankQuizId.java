package exam.blankquizContext.domain.model.blankquiz;

import exam.blankquizContext.domain.shared.ValueObject;

import java.util.Objects;

public class BlankQuizId implements ValueObject<BlankQuizId> {
  private String id;

  @Override
  public boolean sameValueAs(BlankQuizId other) {
    return equals(other);
  }

  public String nextId() {
    // TODO Generate ID
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    BlankQuizId blankQuizId = (BlankQuizId) o;
    return Objects.equals(id, blankQuizId.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return id;
  }

  public static Object generate() {
    return null;
  }

}