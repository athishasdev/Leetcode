class Solution {
    static class State{
        int r, c;
        int energy;
        int mask;
        int moves;

        State(int r, int c, int energy, int mask,int moves){
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();


        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] litterId = new int[m][n];


        for(int i = 0; i < m; i++){
            Arrays.fill(litterId[i],-1);
            for(int j = 0; j < n; j++){
                if(classroom[i].charAt(j) == 'S'){
                    sr = i;
                    sc = j;
                }
                else if(classroom[i].charAt(j) == 'L'){
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int target = (1 << litterCount) - 1;

        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(sr,sc,energy,0,0));

        boolean[][][][] visited = new boolean[m][n][energy+1][1 << litterCount];

        visited[sr][sc][energy][0] = true;

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};


        while(!queue.isEmpty()){
            State cur = queue.poll();

            if(cur.mask == target){
                return cur.moves;
            }

            for(int[] d : dir){
                int nr = cur.r + d[0];
                int nc = cur.c + d[1];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n){
                    continue;
                }

                if(classroom[nr].charAt(nc) == 'X'){
                    continue;
                }

                if(cur.energy == 0){
                    continue;
                }

                int newEnergy = cur.energy-1;

                if(classroom[nr].charAt(nc) == 'R'){
                    newEnergy = energy;
                }

                int newMask = cur.mask;
                int id = litterId[nr][nc];

                if(id != -1){
                    newMask = newMask | (1 << id);
                }

                if(visited[nr][nc][newEnergy][newMask]){
                    continue;
                }

                visited[nr][nc][newEnergy][newMask] = true;

                queue.offer(new State(
                    nr,
                    nc,
                    newEnergy,
                    newMask,
                    cur.moves+1
                ));
            }
        }
        return -1;

    }
}