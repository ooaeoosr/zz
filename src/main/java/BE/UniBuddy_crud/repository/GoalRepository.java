package BE.UniBuddy_crud.repository;

import BE.UniBuddy_crud.domain.Goal;
import BE.UniBuddy_crud.dto.GoalDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface GoalRepository extends JpaRepository<Goal, Integer> {
    Goal getByMonth(LocalDate month);
}
