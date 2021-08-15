package net.Programmers.practice.Search;

public class Score {
    public String solution(int[][] scores) {

        double[] answer = new double[scores.length];


        for(int i=0;i<scores[0].length;i++){
            int[] max = new int[]{0,i};
            int[] min = new int[]{Integer.MAX_VALUE,i};
            boolean maxFlag = false;
            boolean minFlag = false;

            int sum=0;

            for(int j =0;j<scores.length;j++){
                sum+=scores[j][i];
                if(max[0]<scores[j][i]){
                    max = new int[]{scores[j][i],j};
                    maxFlag=false;
                }else if(max[0]==scores[j][i])maxFlag=true;
                if(min[0]>scores[j][i]){
                    System.out.println("i="+i+", j="+j);
                    min = new int[]{scores[j][i],j};
                    minFlag=false;
                } else if(min[0]==scores[j][i])minFlag=true;
            }

            if(!maxFlag&&max[1]==i)answer[i]=(sum-max[0])/(double)(scores.length-1);
            else if(!minFlag&&min[1]==i)answer[i]=(sum-min[0])/(double)(scores.length-1);
            else answer[i]=sum/(double)scores.length;
        }

        return toStringScore(answer);
    }

    String toStringScore(double[] arr){
        StringBuilder builder = new StringBuilder();

        for(double d : arr){
            if(d>=90.0)builder.append("A");
            else if (d>=80.0)builder.append("B");
            else if (d>=70.0)builder.append("C");
            else if (d>=50.0)builder.append("D");
            else builder.append("F");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Score().solution(new int[][]{{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}}));
    }
}
