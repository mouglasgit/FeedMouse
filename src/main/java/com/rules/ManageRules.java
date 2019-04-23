package com.rules;

import java.util.ArrayList;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class ManageRules {

	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			// start here

			Mouse mouse = new Mouse("start", "");

			Cheese cheese = new Cheese(9, 8);
			Mousetrap mtrapLeft = new Mousetrap(0, 4);
			Mousetrap mtrapDown = new Mousetrap(4, 9);
			Crumbs crumbs = new Crumbs(5, 4);

			ArrayList<Mousetrap> listTraps = new ArrayList<>();

			listTraps.add(mtrapLeft);
			listTraps.add(mtrapDown);

			Game game = new Game(mouse, cheese, listTraps);
			game.setVisible(true);

			kSession.insert(mouse);
			kSession.insert(cheese);
			kSession.insert(crumbs);
			kSession.insert(mtrapLeft);
			kSession.insert(mtrapDown);
			kSession.insert(game);

			kSession.fireAllRules();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
