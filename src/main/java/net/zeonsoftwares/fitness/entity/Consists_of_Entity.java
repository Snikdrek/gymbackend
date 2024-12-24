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
@Table(name = "consists_of") // Table name in lowercase
public class Consists_of_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID for the relationship
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_plan_name", referencedColumnName = "workout_plan_name", nullable = false) // Foreign key to WorkoutPlanEntity
    private WorkoutPlanEntity workoutPlan;

    @ManyToOne
    @JoinColumn(name = "workout_name", referencedColumnName = "workout_name", nullable = false) // Foreign key to WorkoutsEntity
    private WorkoutsEntity workout;
}
