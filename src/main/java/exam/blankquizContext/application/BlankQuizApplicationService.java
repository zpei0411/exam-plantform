package exam.blankquizContext.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import exam.blankquizContext.domain.blankQuiz.BlankQuiz;
import exam.blankquizContext.domain.blankQuiz.BlankQuizId;
import exam.blankquizContext.domain.blankQuiz.BlankQuizRepository;
import exam.paperContext.domain.service.BlankQuizDto;
import exam.paperContext.domain.service.BlankQuizClient;

import org.springframework.stereotype.Service;

public class BlankQuizApplicationService {
  private BlankQuizRepository blankQuizRepository;

  @Autowired
  public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
    this.blankQuizRepository = blankQuizRepository;
  }

  public BlankQuizId create(CreateBlankQuizCommand command) {
    final BlankQuizId blankQuizId = blankQuizRepository.nextBlankQuizId();

    final BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, command.getContent(), command.getReferenceAnswer());
    blankQuizRepository.save(blankQuiz);

    return blankQuizId;
  }

  public void revise(String blankQuizId, CreateBlankQuizCommand command) {
    final BlankQuiz blankQuiz = blankQuizRepository.find(new BlankQuizId(blankQuizId));
    blankQuiz.revise(command.getTeacherId(), command.getContent(), command.getReferenceAnswer());

    blankQuizRepository.save(blankQuiz);
  }

  public void delete(String blankQuizId) {
    final BlankQuiz blankQuiz = blankQuizRepository.find(new BlankQuizId(blankQuizId));
    blankQuizRepository.remove(blankQuiz);
  }
}