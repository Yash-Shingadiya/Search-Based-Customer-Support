package troubleshootsearch.element;

import troubleshootsearch.visitor.ExactMatcher;
import troubleshootsearch.visitor.NaiveBayesMatcher;
import troubleshootsearch.visitor.SemanticMatcher;

public interface Element{ 
    
    public void accept(ExactMatcher exactMatcher);
    public void accept(NaiveBayesMatcher naiveBayesMatcher); 
    public void accept(SemanticMatcher semanticMatcher);  
    public void accept(ExactMatcher exactMatcher, String inputFile);
    public void accept(NaiveBayesMatcher naiveBayesMatcher, String inputFile); 
    public void accept(SemanticMatcher semanticMatcher, String inputFile);  
} 