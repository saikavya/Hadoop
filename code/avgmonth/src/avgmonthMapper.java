import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.commons.lang.StringUtils;
public class avgmonthMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, FloatWritable> {
	
public void map(LongWritable key, Text value, OutputCollector<Text, FloatWritable> output, Reporter reporter) throws IOException {
    	{
    	String[] line = value.toString().split(",");
    	try {  //handling array index out of bound exception
	    	String datepart = line[2];//date
	    	String temp= line[3];//temperature
	    	try{
	    	String month= datepart.substring(0,7);	//date & month
	    
	    try{  //handling numberformat exception
	      output.collect(new Text(month),new FloatWritable(Float.parseFloat(temp)));
	    }
	    catch(NumberFormatException ex) {
	        //from_value = 0.0; // default ??
	    }
	    	}
	    	catch (ArrayIndexOutOfBoundsException e) {
	    	}
	    	}
	    	catch (Exception e){
	    		
	    	}}}}
