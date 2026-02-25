import java.io.*;
import java.util.*;

public class Main {

    static int p, m;

    static class Room {
        int level;
        ArrayList<Player> players;
        Boolean canMore;

        public Room(int level, Player p) {
            this.level = level;
            this.players = new ArrayList<>();
            players.add(p);
            if(m == 1) canMore = false;
            else canMore = true;
        }
    }

    static class Player implements Comparable<Player> {

        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Room> rooms = new ArrayList<>();
        for(int i = 0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            Player pl = new Player(l, n);

            if(rooms.isEmpty()){
                rooms.add(new Room(l, pl));
                continue;
            }

            boolean requireMake = true;
            for(Room room: rooms){
                if(room.canMore && Math.abs(room.level - pl.level) <= 10) {
                    room.players.add(pl);
                    if(room.players.size() == m) room.canMore = false;
                    requireMake = false;
                    break;
                }
            }

            if(requireMake){
                rooms.add(new Room(l, pl));
            }
        }

        for(Room room: rooms){
            if(!room.canMore){
                System.out.println("Started!");
            }else {
                System.out.println("Waiting!");
            }

            Collections.sort(room.players);

            for(Player pl: room.players){
                System.out.println(pl.level + " " + pl.nickname);
            }
        }
    }
}