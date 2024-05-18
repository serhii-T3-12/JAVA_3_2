
package app;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Controller {
    @FXML
    public Button checkActorButton;
    @FXML
    public Button findCoActorsButton;
    @FXML
    public Button findMovieButton;
    @FXML
    public ChoiceBox <Model.Actor> actorComboBox;


    private Model.Database database;

    @FXML
    private void initialize() {
        // Створюємо списки акторів
        Model.Actor actor1 = new Model.Actor("Actor1", new ArrayList<>());
        Model.Actor actor2 = new Model.Actor("Actor2", new ArrayList<>());
        Model.Actor actor3 = new Model.Actor("Actor3", new ArrayList<>());
        Model.Actor actor4 = new Model.Actor("Actor4", new ArrayList<>());
        Model.Actor actor5 = new Model.Actor("Actor5", new ArrayList<>());
        // Створюємо фільми та додаємо акторів до них
        Model.Movie movie1 = new Model.Movie("Movie1", List.of(actor1, actor2));
        Model.Movie movie2 = new Model.Movie("Movie2", List.of(actor2, actor3, actor4));
        Model.Movie movie3 = new Model.Movie("Movie3", List.of(actor2, actor3, actor1, actor5));
        // Додаємо фільми до списку
        List<Model.Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        // Додаємо акторів до списку
        List<Model.Actor> actors = new ArrayList<>();
        actors.add(actor1);
        actors.add(actor2);
        actors.add(actor3);
        actors.add(actor4);
        actors.add(actor5);

        // Ініціалізуємо базу даних з фільмами та акторами
        database = new Model.Database(movies, actors);
        // Ініціалізуємо комбо бокс для відображення акторів

        // Налаштовуємо, як відображати елементи в комбо боксі
        actorComboBox.setItems(FXCollections.observableArrayList(actors));
        // Налаштовуємо, як відображати елементи в комбо боксі
        actorComboBox.setConverter(new StringConverter<Model.Actor>() {
            @Override
            public String toString(Model.Actor actor) {
                if (actor != null) {
                    return actor.getName(); // Повертаємо ім'я актора
                } else {
                    return ""; // Повертаємо порожню строку, якщо актор є null
                }
            }

            @Override
            public Model.Actor fromString(String string) {
                //  також потрібно реалізувати цей метод, для використовувати комбо бокс для редагування
                return null;
            }
        });

    }

    // Викликаємо метод findCoActors при натисканні кнопки
    @FXML
    private void findCoActors() {
        // Отримуємо вибраного актора з комбо боксу
        Model.Actor selectedActor = actorComboBox.getValue();

        // Перевіряємо, чи актор вибраний
        if (selectedActor != null) {
            // Якщо актор вибраний, викликаємо метод findCoActors, передаючи вибраного актора та базу даних
            List<Model.Actor> coActors = findCoActors(selectedActor, database);
            resultArea.setText("Co-Actors: " + coActors);
        } else {
            // Якщо актор не вибраний, виводимо повідомлення про помилку
            resultArea.setText("Please select an actor.");
        }
    }
    @FXML
    private List<Model.Actor> findCoActors(Model.Actor actor, Model.Database database) {
        return database.getMovies().stream()                            // Створюємо Stream фільмів
                .filter(movie -> movie.getActors().contains(actor))    // Фільтруємо фільми, в яких заданий актор грав
                .flatMap(movie -> movie.getActors().stream())          // Розгортаємо список акторів у кожному фільмі до окремого Stream
                .distinct()                                            // Видаляємо дублікати акторів
                .filter(coActor -> !coActor.equals(actor))             // Відфільтровуємо самого актора
                .toList();                                             // Перетворюємо Stream в List
    }




    @FXML
    private TextArea resultArea;

    @FXML
    private void checkActor() {
        boolean hasActorWithNoMovies = hasActorWithNoMovies(database);
        resultArea.setText("Actor with no movies: " + hasActorWithNoMovies);
    }


@FXML
private void findMovie() {
    Model.Movie movieWithMostActors = findMovieWithMostActors(database);
    if (movieWithMostActors != null) {
        resultArea.setText("Movie with most actors: " + movieWithMostActors.getTitle());
    } else {
        resultArea.setText("No movie found with actors");
    }
}


    // Методи з базового коду
    private boolean hasActorWithNoMovies(Model.Database database) {
        return database.getActors().stream().anyMatch(actor -> actor.getMovies().isEmpty());
    }


    private Model.Movie findMovieWithMostActors(Model.Database database) {
        return database.getMovies().stream()
                .max(Comparator.comparingInt(movie -> movie.getActors().size()))
                .orElse(null);
    }
}
