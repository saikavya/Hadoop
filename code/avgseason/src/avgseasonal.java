import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

public class avgseasonal {
	public static void main(String[] args) throws Exception {
	     JobConf conf = new JobConf(avgseasonal.class);
	     conf.setJobName("monthlyaverage");
	
	     conf.setOutputKeyClass(Text.class);
	     conf.setOutputValueClass(FloatWritable.class);
	     conf.setNumReduceTasks(2);//setting reducer
	     conf.setNumMapTasks(10);//setting mapper
	
	     conf.setMapperClass(avgseasonalMapper.class);
	      conf.setReducerClass(avgseasonalReducer.class);
	
	     FileInputFormat.setInputPaths(conf, new Path(args[0]));
	     FileOutputFormat.setOutputPath(conf, new Path(args[1]));
	
	     JobClient.runJob(conf);
	   }

}
