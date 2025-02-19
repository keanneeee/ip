//import java.util.Scanner;
//
//public class Keane {
//
//    private void goodbye(String[] arg){
//        System.out.println("Bye! Hope to see you again soon!");
//    }
//
//    public static void main(String[] args) {
//        String bye = "bye";
//        String[] words = new String[100];
//        System.out.println("Hello! I'm Keane.");
//        System.out.println("What is up fella?");
//        Scanner in = new Scanner(System.in);
//        int count = 0;
//        Tasks tasks = new Tasks();
//
//        while(true) {
//            String line = in.nextLine();
//            if (line.equalsIgnoreCase(bye)) {
//                System.out.println("Bye. Hope to see you again soon!");
//                break;
//            } else if (line.equalsIgnoreCase("List")) {
//                for (String word : words) {
//                    if (word != null) {
//                        System.out.println(word);
//                    }
//                }
//            } else if(line.contains("mark") && (Integer.parseInt(line.substring(5)) <= count + 1)) {
//                int taskNum = Integer.parseInt(line.substring(5)) - 1;
//                tasks.savetask(words[taskNum]);
//                words[taskNum] = temp.replaceFirst(" ", "X");
//                System.out.println("sure king");
//                System.out.println(words[taskNum]);
//                System.out.println("anything else?");
//            } else if(line.contains("unmark") && (Integer.parseInt(line.substring(5)) <= count + 1)){
//                int taskNum = Integer.parseInt(line.substring(5)) - 1;
//                String temp = words[taskNum];
//                System.out.println("sure king");
//                words[taskNum] = temp.replaceFirst("X", " ");
//                System.out.println("anything else?");
//            }  else if((line.contains("mark")||line.contains("unmark")) && ((Integer.parseInt(line.substring(5)) > count) || (Integer.parseInt(line.substring(5)) < 0))) {
//                System.out.println("king please enter a valid number");
//            }
//            else {
//                tasks.saveTasks(line);
//                words[count] = count+1 + "." + tasks.getId();
//                count++;
//                System.out.println("Added: "+ line);
//            }
//        }
//        in.close();
//    }
//}
////coding standard checked
////will edit fringe cases by this week psps
