package exam.blankquizContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class CreateBlankQuizCommand {
  private String content;
  private String referenceAnswer;
}