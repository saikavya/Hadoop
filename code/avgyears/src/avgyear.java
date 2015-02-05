import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class avgyear {
	public static void main(String[] args) throws Exception {
	     JobConf jobyr = new JobConf(avgyear.class);
	     
	     jobyr.setJobName("monthlyaverage");
	
	     jobyr.setOutputKeyClass(Text.class);
	     jobyr.setOutputValueClass(FloatWritable.class);
	
	     jobyr.setMapperClass(avgyearMapper.class);
	     jobyr.setReducerClass(avgyearReducer.class);
	
	     FileInputFormat.setInputPaths(jobyr, new Path(args[0]));
	     FileOutputFormat.setOutputPath(jobyr, new Path(args[1]));
	     jobyr.setNumReduceTasks(2);//setting number of reducers
	     jobyr.setNumMapTasks(10);//setting number of mappers
	
	     JobClient.runJob(jobyr);
	   }


}
