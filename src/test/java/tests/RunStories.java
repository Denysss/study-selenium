package tests;

import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import com.thoughtworks.xstream.converters.basic.DateConverter;

public class RunStories extends JUnitStory {
	 
    //private final CrossReference xref = new CrossReference();
    
    public RunStories() {
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).useThreads(2);
        // Uncomment to set meta filter, which can also be set via Ant or Maven
        // configuredEmbedder().useMetaFilters(Arrays.asList("+theme parametrisation"));
    }
 
    //@SuppressWarnings("deprecation")
	@Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");

        ParameterConverters parameterConverters = new ParameterConverters();

        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(),
                new LoadFromClasspath(embeddableClass), parameterConverters);

        parameterConverters.addConverters((ParameterConverter) new DateConverter("yyyy-MM-dd", null),
        		new ExamplesTableConverter(examplesTableFactory));
 
        return new MostUsefulConfiguration()
                //.useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryParser(new RegexStoryParser(examplesTableFactory))
                //.useStoryPathResolver(new UnderscoredCamelCaseResolver())
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                                .withDefaultFormats()
                                //.withPathResolver(new FilePathResolver)
                                //.withViewResources(viewResources)
                                .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML)
                                //.withFailureTrace(true)
                                //.withFailureTraceCompression(true)
                                //.withCrossReference(xref)
                                )
                .useParameterConverters(parameterConverters)
                // use '%' instead of '$' to identify parameters
                //.useStepPatternParser(new RegexPrefixCapturingPatternParser("%")) 
                //.useStepMonitor(xref.getStepMonitor())
                ;
    }
 
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new LoginSteps());
    }
 
} 