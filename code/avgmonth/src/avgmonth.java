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
public class avgmonth {
public static void main(String[] args) throws Exception {
	     JobConf job = new JobConf(avgmonth.class);
	     job.setJobName("monthlyaverage");
	
	     job.setOutputKeyClass(Text.class);
	     job.setOutputValueClass(FloatWritable.class);
	     job.setNumReduceTasks(2);//reducers
	     job.setNumMapTasks(10);	//mappers
	     job.setMapperClass(avgmonthMapper.class);
	     job.setReducerClass(avgmonthReducer.class);
	
	     FileInputFormat.setInputPaths(job, new Path(args[0]));
	     FileOutputFormat.setOutputPath(job, new Path(args[1]));
	
	     JobClient.runJob(job);
	   }

}
