/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main class for run program
 * @author jelena
 */
public class GitTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Strategy gitHubToolFactory = new Strategy();
        GitHubTool gitHubTool = null;

        if (args.length == 0) {
            System.out.print(StaticVariables.commands);
        } else if (args[0].equals(StaticVariables.list) && (args.length == 1 || !args[1].equals(StaticVariables.ruby))) {

            ListGitTool tool = (ListGitTool) gitHubToolFactory.getTool(StaticVariables.list, args);
            tool.runGitHubTool();

        } else if (args.length > 1 && args[1].equals(StaticVariables.ruby)) {
            gitHubTool = gitHubToolFactory.getTool(StaticVariables.listRuby, args);
            gitHubTool.runGitHubTool();
        } else if (args[0].equals(StaticVariables.desc) && args.length == 1) {

            System.out.print(StaticVariables.descDetails);
        } else if (args[0].equals(StaticVariables.desc) && args.length > 1) {
            ExecutorService executor = Executors.newFixedThreadPool(5);
            for (int i = 1; i < args.length; i++) {

                DescGitHubTool tool = new DescGitHubTool(Integer.parseInt(args[i]));

                executor.execute(tool);
            }
            executor.shutdown();
        } else {
            System.exit(45);
        }

    }

}
