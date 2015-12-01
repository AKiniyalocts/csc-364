/**
  Class: Dag
  Created by: Anthony Kiniyalocts
  11/30/15

**/

public class Dag {

	private boolean[][] G;
	private int[] inDegree;
	private boolean[] scheduled;
  private int numvertices;

	public Dag(int N) {
		this.G = new boolean[N][N];
		this.inDegree = new int[N];
		this.scheduled = new boolean[N];
		this.numvertices = N;
	}

	public void setXY(int X, int Y) {
		G[X][Y] = true;
	}

	public void setInDegree() {
		for (int x = 0; x < numvertices; x++) {
			int count = 0;

			for (int y = 0; y < numvertices; y++) {

				if (G[y][x]) {
					count++;
				}

			}
			inDegree[x] = count;
		}
	}

	public void topologicalSort() {
		int count = 0;

		while (count < numvertices) {

			for (int i = 0; i < numvertices; i++) {

				if (!scheduled[i] && inDegree[i] == 0) {

					scheduled[i] = true;

					count++;

					System.out.println(i);

					for (int j = 0; j < numvertices; j++) {

						if (G[i][j]) {

							inDegree[j] = inDegree[j] - 1;

						}

					}
				}
			}
		}
	}
}
