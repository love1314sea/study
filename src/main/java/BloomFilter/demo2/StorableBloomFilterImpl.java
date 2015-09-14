package BloomFilter.demo2;

import BloomFilter.demo2.bean.BloomFilterBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wushang on 15/7/21.
 */
interface StorableBloomFilterImpl {

    public BloomFilterBean getOrCreateBf(String key);
    public boolean removeBf(String key);
    public List<String> getBfNames();
    public BloomFilterBean getBf(String key);
}
