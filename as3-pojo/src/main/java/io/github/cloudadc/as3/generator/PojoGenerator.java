package io.github.cloudadc.as3.generator;

import java.net.URL;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.RuleFactory;

import com.sun.codemodel.JCodeModel;

public class PojoGenerator {

	public static void main(String[] args) {
		
		JCodeModel codeModel = new JCodeModel();
		
		//URL source = PojoGenerator.class.getResource("/schema/3.36.0/as3-schema-3.36.0-6-cis.json");
		URL source = PojoGenerator.class.getResource("/schema/3.18.0/as3-schema-3.18.0-4-cis.json");
		
		GenerationConfig config = new DefaultGenerationConfig() {

			@Override
			public boolean isGenerateBuilders() {
				return true;
			}
		};
			
		SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
		mapper.generate(codeModel, "Template", "io.github.cloudadc.as3.pojo", source);
		
		System.out.println("DONE");

	}

}
