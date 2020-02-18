package cn.superman.mahout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.List;

import org.apache.mahout.cf.taste.common.Weighting;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class ItemCF {
	public Integer getProgramId(int uid) throws Exception {
		String file = "D:\\java oj\\JavaOJSystem\\src\\main\\java\\data\\mahoutData.txt";
        DataModel model = new FileDataModel(new File(file));//数据模型
        //ItemSimilarity item=new EuclideanDistanceSimilarity(model);//用户相识度算法
        ItemSimilarity item = new PearsonCorrelationSimilarity(model,Weighting.WEIGHTED);//皮尔森相关度*9
        Recommender r=new GenericItemBasedRecommender(model,item);//物品推荐算法
        LongPrimitiveIterator iter =model.getUserIDs();
        while(iter.hasNext()){
        	if(iter.nextLong() == uid) {
        		List<RecommendedItem> list = r.recommend(uid, 1);
        		return (int) list.get(0).getItemID();
        	}      	
        }
		return null;
	}
	
	public void save(int uid,BigInteger pid,double value) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\java oj\\JavaOJSystem\\src\\main\\java\\data\\mahoutData.txt", true));
		String str = "";
		str = "\n" + uid + "," + pid + "," + value;
		bw.write(str);
		bw.flush();
		bw.close();
		
	}
}
