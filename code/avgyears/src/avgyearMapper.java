import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class avgyearMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, FloatWritable> {
		
		public void map(LongWritable key, Text value, OutputCollector<Text, FloatWritable> output, Reporter reporter) throws IOException {
		    	{
		    	String[] line = value.toString().split(",");// putting row into a line
		    	try {                                         //handling ArrayOutOfBound Exception
		    	String datepart = line[2];                //date
		    	String temp= line[3];                     //temperature
		    	//String prcp=line[20];
		    	try{
		    	String year= datepart.substring(0,5);	//year
		    
		    try{                                       //handling number format exception 
		      output.collect(new Text(year),new FloatWritable(Float.parseFloat(temp)));//key-year, value-corresponding temperature values
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


