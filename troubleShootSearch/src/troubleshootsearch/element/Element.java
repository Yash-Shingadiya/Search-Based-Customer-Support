package troubleshootsearch.element;

import troubleshootsearch.visitor.ExactMatcher;
import troubleshootsearch.visitor.NaiveBayesMatcher;
import troubleshootsearch.visitor.SemanticMatcher;

public interface Element{ 
    
    public void accept(ExactMatcher exactMatcher);
    public void accept(NaiveBayesMatcher naiveBayesMatcher); 
    public void accept(SemanticMatcher semanticMatcher);  
    public String accept(ExactMatcher exactMatcher, String inputFile);
    public String accept(NaiveBayesMatcher naiveBayesMatcher, String inputFile); 
    public String accept(SemanticMatcher semanticMatcher, String inputFile);  
} 