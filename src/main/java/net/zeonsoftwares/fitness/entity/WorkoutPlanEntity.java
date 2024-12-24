package net.zeonsoftwares.fitness.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workoutPlans") // Table name in lowercase
public class WorkoutPlanEntity {

    @Id
    @Column(name = "workout_plan_name", nullable = false, unique = true) // Maps to 'WorkoutPlanName' as primary key
    private String workoutPlanName;
    @ManyToOne
    @JoinColumn(name = "workout_plan_trainer_id", referencedColumnName = "trainer_id") // Foreign key to TrainerEntity (trainer_id is the primary key)
    private TrainerEntity trainer; // The trainer who created this workout plan
}

