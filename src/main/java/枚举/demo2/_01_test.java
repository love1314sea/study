package 枚举.demo2;

import java.util.Locale;

/**
 * Created by wushang on 15/10/28.
 */
public class _01_test {

    /**
     * Enumeration of built in channel types available in the system.
     */
    public enum ChannelType {

        /**
         * Place holder for custom channels not part of this enumeration.
         */
        OTHER(null),

        FILE("org.apache.flume.channel.file.FileChannel"),

        /**
         * Memory channel
         */
        MEMORY("org.apache.flume.channel.MemoryChannel"),

        /**
         * JDBC channel provided by org.apache.flume.channel.jdbc.JdbcChannel
         */
        JDBC("org.apache.flume.channel.jdbc.JdbcChannel"),

        /**
         * Spillable Memory channel
         */
        SPILLABLEMEMORY("org.apache.flume.channel.SpillableMemoryChannel");

        private final String channelClassName;

        private ChannelType(String channelClassName) {
            this.channelClassName = channelClassName;
        }

        public String getChannelClassName() {
            return channelClassName;
        }
    }

    public static ChannelType getKnownChannel(String type) {
        ChannelType[] values = ChannelType.values();
        //枚举类型：区分toString 方法和 getChannelClassName
        //
        for (ChannelType value : values) {
            if (value.toString().equalsIgnoreCase(type)) return value;

            String channel = value.getChannelClassName();

            if (channel != null && channel.equalsIgnoreCase(type)) return value;

        }
        return null;
    }

    public static void main(String[] args) {
        ChannelType chType = getKnownChannel("memory");
        String config = chType.toString().toUpperCase(Locale.ENGLISH);
        System.out.println(config);

        ChannelType file1 = ChannelType.valueOf("FILE");//通过字符串获取
        ChannelType file2 = ChannelType.FILE;//直接定义获取

        System.out.println(file1);
        if(file1.equals(file2)) {//可以用equals来比较是否相等
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
