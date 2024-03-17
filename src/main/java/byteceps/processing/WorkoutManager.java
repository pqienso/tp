package byteceps.processing;


import byteceps.activities.Workout;
import byteceps.commands.Parser;
import byteceps.errors.Exceptions;

public class WorkoutManager extends ActivityManager {
    @Override
    public void execute(Parser parser) throws Exceptions.ErrorAddingActivity, Exceptions.ActivityExistsException {
        switch (parser.getAction()) {
        case "create":
            Workout newWorkout = processCreateWorkout(parser);
            add(newWorkout);
            //   System.out.printf("Added exercise: %s\n", newExercise.getActivityName());
            break;
        case "assign":
            // similar to exercise's edit I think?
            // find the exercises available in the exercise manager (might need to pass in)
            // add to the workoutList in the workout class
            break;
        case "unassign":
            break;
        case "samples":
            break;
        case "list":
            if(parser.getActionParameter() == null) {
                list();
            } else {
                list(parser.getActionParameter());
            }
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + parser.getAction());
        }
    }

    public Workout processCreateWorkout(Parser parser) {
        // check if parser is valid if not throw errors
        return new Workout(parser.getActionParameter());
    }

    //todo: attempts to search for the workout name and lists that 1 workout
    public void list(String workoutName) {
        //add code here
    }
    @Override
    public String getActivityType(boolean plural) {
        return plural ? "Workouts" : "Workout";
    }
}