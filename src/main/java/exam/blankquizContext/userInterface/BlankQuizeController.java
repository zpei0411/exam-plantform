package exam.blankquizContext.userInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import exam.blankquizContext.application.BlankQuizApplicationService;
import exam.blankquizContext.application.CreateBlankQuizCommand;
import exam.blankquizContext.domain.blankQuiz.BlankQuizId;
import exam.blankquizContext.infrastructure.MemoryBlankQuizRepository;

import org.springframework.http.HttpStatus;

@RestController
public class BlankQuizeController {
  private BlankQuizApplicationService blankQuizApplicationService;

  @Autowired
  public void BlankQuizController(BlankQuizApplicationService blankQuizApplicationService) {
    this.blankQuizApplicationService = blankQuizApplicationService;
  }

  @PostMapping("/blankQuizzes")
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  BlankQuizId create(@RequestBody CreateBlankQuizCommand command) {
    return blankQuizApplicationService.create(command);
  }

  @PutMapping("/blankQuizzes/{blankQuizId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void update(@PathVariable String blankQuizId, @RequestBody CreateBlankQuizCommand command) {
    blankQuizApplicationService.revise(blankQuizId, command);
  }

  @DeleteMapping("/blankQuizzes/{blankQuizId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void delete(@PathVariable String blankQuizId) {
    blankQuizApplicationService.delete(blankQuizId);
  }

}
