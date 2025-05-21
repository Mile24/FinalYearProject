
import java.io.BufferedReader;
import java.io.InputStreamReader;

public  String runSentimentAnalysisScript(int feedbackId) {
    String sentiment = "neutral";
    try {
        ProcessBuilder pb = new ProcessBuilder("python3", "path/to/bert_sentiment.py", String.valueOf(feedbackId));
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        sentiment = reader.readLine(); // Read first line of output

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            System.err.println("BERT script failed with code: " + exitCode);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return sentiment;
}
