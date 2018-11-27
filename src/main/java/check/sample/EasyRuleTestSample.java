package check.sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;

public class EasyRuleTestSample {
	public static void main(String[] args) throws FileNotFoundException {
		//Read the sample file from the local
		FileReader fr = new FileReader(Paths.get("D:\\SampleRule.yml").toFile());
		
		//Read the list of rule from YML
		Rules mainRules = MVELRuleFactory.createRulesFrom(fr);
		RulesEngine rulesEngine = new DefaultRulesEngine();
		Facts fact = new Facts();
		AppLink appLinkInfo = null;
		
		//Rule 1 - When the Applink is Remedy Jira
		System.out.println("Executing Rule - Check 1:");
		appLinkInfo = new AppLink();
		appLinkInfo.setAppLinkName("RemedySnow");
		fact.put("applinkInfo", appLinkInfo);
		rulesEngine.fire(mainRules, fact);
		System.out.println(appLinkInfo.getId());
		System.out.println(appLinkInfo.getName());
        System.out.println(appLinkInfo.getDesc());
        
        System.out.println("\n \n \n");
        		
        //Rule 2 - When the Applink is Remedy Snow
		System.out.println("Executing Rule - Check 2:");
		appLinkInfo = new AppLink();
		appLinkInfo.setAppLinkName("RemedyJira");
		fact.put("applinkInfo", appLinkInfo);
		rulesEngine.fire(mainRules, fact);
        System.out.println(appLinkInfo.getId());
        System.out.println(appLinkInfo.getName());
        System.out.println(appLinkInfo.getDesc());
	}
}
