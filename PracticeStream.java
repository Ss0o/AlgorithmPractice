import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class F1 {

    private String team_name;
    private String player_name;

    public F1(String team_name,String player_name) {
        this.team_name = team_name;
        this.player_name = player_name;
    }


    public String getTeam_name() {
        return team_name;
    }
    public String getPlayer_name() {
        return player_name;
    }
}
public class PracticeStream {
    public static void main(String[] args) {
        Stream<Integer> iteratedStream = Stream.iterate(0, n->n+2).limit(5);
        iteratedStream.forEach(a-> System.out.print(a + ", "));

        List<F1> F1List = Arrays.asList(
                new F1("레드불", "베르스타펜"),
                new F1("메르세데스", "해밀턴"),
                new F1("맥라렌", "노리스")
        );

        System.out.println();
        Stream<F1> stream = F1List.stream();
        stream.forEach(s -> System.out.println("팀 이름: " + s.getTeam_name() + ", 플레이어 이름: " + s.getPlayer_name()));
    }
}
