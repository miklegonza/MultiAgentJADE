package main;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Main {

    public static void main(String[] args) {
        try {
            Runtime runtime = Runtime.instance();
            Profile profile = new ProfileImpl();
            profile.setParameter(Profile.MAIN_HOST, "127.0.0.1");
            profile.setParameter(Profile.GUI, "true");

            ContainerController container = runtime.createMainContainer(profile);
            AgentController agent;

            agent = container.createNewAgent("FirstAgent", "main.FirstAgent", null);

            agent.start();

        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }

}
