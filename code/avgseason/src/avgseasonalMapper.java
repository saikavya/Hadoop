import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class avgseasonalMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, FloatWritable> {
	
public void map(LongWritable key, Text value, OutputCollector<Text, FloatWritable> output, Reporter reporter) throws IOException {
    	{
    	String[] line = value.toString().split(",");
    	try {                                            //handling array index out of bound exception
	    	String datepart = line[2];//date
	    	String temp= line[3];//temperature
	    	try{
	    	String month= datepart.substring(0,5);	//year
	    	String m=datepart.substring(5,7);//month
	    	String season = null;
	    	int k= Integer.parseInt(m);
	    	switch(k)
	    	{
	    	case 01: season="winter";
	    	break;
	    	case 02: season="winter";
	    	break;
	    	case 03: season="spring";
	    	break;
	    	case 04: season="spring";
	    	break;
	    	case 05: season="spring";
	    	break;
	    	case 06: season="summer";
	    	break;
	    	case 07: season="summer";
	    	break;
	    	case 010: season="summer";
	    	break;
	    	case 011: season="autumm";
	    	break;
	    	case 012: season="autumm";
	    	break;
	    	case 013: season="autumm";
	    	break;
	    	case 014: season="winter";
	    	break;
	    	default:return;
	    	
	    	}
	    		
	    try{                        //handling numberformat exception
	      output.collect(new Text(month+season),new FloatWritable(Float.parseFloat(temp)));
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


