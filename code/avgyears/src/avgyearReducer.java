import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;


public class avgyearReducer extends MapReduceBase implements Reducer<Text, FloatWritable, Text, FloatWritable> {
    public void reduce(Text key, Iterator<FloatWritable> values, OutputCollector<Text, FloatWritable> output, Reporter reporter) throws IOException {
	       Float sum = (float) 0.0;
	       Float count=(float) 0.00;
	       while (values.hasNext()) {
	         sum += values.next().get();
	         count+=1;
	       }
	       output.collect(key, new FloatWritable(sum/count));
	     }
}
