package BloomFilter.demo2;

import BloomFilter.demo2.bean.BloomFilterBean;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wushang on 15/7/21.
 */
public class FileBloomFilter implements StorableBloomFilterImpl {

    private String dir;
    private ConcurrentHashMap<String,BloomFilterBean> bfMap = new ConcurrentHashMap<>();

    public FileBloomFilter(String dir) {
        this.dir = dir;
    }
    public BloomFilterBean getOrCreateBf(String key) {
        if(bfMap.containsKey(key)) {
            return bfMap.get(key);
        }
        //TODO 生成bf
        BloomFilterBean bloomFilterBean = new BloomFilterBean();
        bfMap.put(key, bloomFilterBean);
        return bloomFilterBean;
    }

    public boolean removeBf(String key) {
        BloomFilterBean bf = bfMap.remove(key);
        if(bf == null)
            return false;
        else {
            bf = null;
            return true;
        }
    }

    @Override
    public List<String> getBfNames() {
//        return Arrays.asList(bfMap.keySet().toArray().toString());
        return Lists.newArrayList(bfMap.keySet());
    }

    @Override
    public BloomFilterBean getBf(String key) {
        return bfMap.get(key);
    }

    public void flush(String key) throws IOException {
        if(bfMap.contains(key)) {
            File file = new File(dir, key);
            FileUtils.writeByteArrayToFile(file, bfMap.get(key).serialize());
        }
    }

    public void flushAll( ) throws IOException {
        for(Map.Entry<String, BloomFilterBean> entry:bfMap.entrySet()) {
            flush(entry.getKey());
        }
    }
 }
