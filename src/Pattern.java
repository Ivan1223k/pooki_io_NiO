interface TextProcessor {
    String process(String text);
}

class SimpleTextProcessor implements TextProcessor {
    public String process(String text) {
        return text;
    }
}

class UpperCaseDecorator implements TextProcessor {
    private final TextProcessor processor;

    public UpperCaseDecorator(TextProcessor processor) {
        this.processor = processor;
    }

    public String process(String text) {
        return processor.process(text).toUpperCase();
    }
}

class TrimDecorator implements TextProcessor {
    private final TextProcessor processor;

    public TrimDecorator(TextProcessor processor) {
        this.processor = processor;
    }

    public String process(String text) {
        return processor.process(text).trim();
    }
}

class ReplaceDecorator implements TextProcessor {
    private final TextProcessor processor;

    public ReplaceDecorator(TextProcessor processor) {
        this.processor = processor;
    }

    public String process(String text) {
        return processor.process(text).replace(" ", "_");
    }
}

public class Pattern {
    public static void main(String[] args) {
        String input = "  Hello World  ";

        TextProcessor processor = new ReplaceDecorator(
                new UpperCaseDecorator(
                        new TrimDecorator(new SimpleTextProcessor())
                )
        );

        String result = processor.process(input);
        System.out.println(result);
    }
}