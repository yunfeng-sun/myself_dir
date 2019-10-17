package config.Impl;

import POJO.ConfigEntity;
import config.ConfigMapService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.ConfigService;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.*;

@Component("commonConfigMapService")
public class ConfigMapServiceImpl implements ConfigMapService {
    @Autowired
    private ConfigService configService;
//    private Set<ConfigChangeListener> listeners = Sets.newConcurrentHashSet();
    private Map<String, ConfigEntity> configs = new HashMap<String, ConfigEntity>();

    public ConfigMapServiceImpl() {
    }

    @PostConstruct
    public void init() {
        List<ConfigEntity> configList = this.configService.findAll();
        Map<String, ConfigEntity> newConfigs = new HashMap<String, ConfigEntity>();
        if (configList.size() > 0) {
            Iterator var3 = configList.iterator();

            while(var3.hasNext()) {
                ConfigEntity config = (ConfigEntity)var3.next();
                String key = config.getName();
                if (!StringUtils.isEmpty(key)) {
                    newConfigs.put(key, config);
                }
            }
        }

        this.configs = newConfigs;
    }

    public void reload() {
//        List<Config> configList = this.configService.findAll();
//        Map<String, Config> newConfigs = Maps.newHashMap();
//        Map<String, String> insertMap = Maps.newHashMap();
//        Map<String, Pair<String, String>> updateMap = Maps.newHashMap();
//        HashMap deleteMap = Maps.newHashMap(this.configs);
//
//        try {
//            if (configList.size() > 0) {
//                Iterator var6 = configList.iterator();
//
//                while(var6.hasNext()) {
//                    Config config = (Config)var6.next();
//                    String key = config.getName();
//                    if (!StringUtils.isEmpty(key)) {
//                        deleteMap.remove(key);
//                        Config oldConfig = (Config)this.configs.get(key);
//                        if (oldConfig == null) {
//                            insertMap.put(key, config.getValue());
//                        } else if (!StringUtils.equals(oldConfig.getValue(), config.getValue())) {
//                            updateMap.put(key, Pair.of(oldConfig.getValue(), config.getValue()));
//                        }
//
//                        newConfigs.put(key, config);
//                    }
//                }
//            }
//
//            Map<String, Config> oldConfigs = this.configs;
//            this.configs = newConfigs;
//            oldConfigs.clear();
//            if (insertMap.size() + updateMap.size() + deleteMap.size() > 0) {
//                this.logger.info("Reload configuration found {} inserted,  {} modified, {} deleted.", new Object[]{insertMap.size(), updateMap.size(), deleteMap.size()});
//                Map<String, ConfigChange> changes = Maps.newHashMap();
//                Iterator var16 = insertMap.entrySet().iterator();
//
//                String key;
//                Map.Entry entry;
//                while(var16.hasNext()) {
//                    entry = (Map.Entry)var16.next();
//                    key = (String)entry.getKey();
//                    changes.put(key, new ConfigChange((String)null, (String)entry.getValue(), PropertyChangeType.ADDED));
//                }
//
//                var16 = updateMap.entrySet().iterator();
//
//                while(var16.hasNext()) {
//                    entry = (Map.Entry)var16.next();
//                    key = (String)entry.getKey();
//                    changes.put(key, new ConfigChange((String)((Pair)entry.getValue()).getKey(), (String)((Pair)entry.getValue()).getValue(), PropertyChangeType.MODIFIED));
//                }
//
//                var16 = deleteMap.entrySet().iterator();
//
//                while(var16.hasNext()) {
//                    entry = (Map.Entry)var16.next();
//                    changes.put(entry.getKey(), new ConfigChange((String)null, ((Config)entry.getValue()).getValue(), PropertyChangeType.DELETED));
//                }
//
//                this.notifyAll(changes);
//            }
//        } finally {
//            insertMap.clear();
//            updateMap.clear();
//            deleteMap.clear();
//        }

    }

    public void onEvent(Object event) {
//        Object entity = event.getEntity();
//        if (entity instanceof Config) {
//            Config newConfig = (Config)entity;
//            String key = newConfig.getName();
//            Config oldConfig = (Config)this.configs.get(key);
//            String oldValue = oldConfig != null ? oldConfig.getValue() : null;
//            ConfigChange change = null;
//            switch(event.getType()) {
//                case UPDATE:
//                    if (!StringUtils.equals(oldValue, newConfig.getValue())) {
//                        change = new ConfigChange(oldValue, newConfig.getValue(), PropertyChangeType.MODIFIED);
//                        this.configs.put(key, newConfig);
//                    }
//                    break;
//                case INSERT:
//                    if (!this.configs.containsKey(key)) {
//                        change = new ConfigChange((String)null, newConfig.getValue(), PropertyChangeType.ADDED);
//                        this.configs.put(key, newConfig);
//                    }
//                    break;
//                case DELETE:
//                    if (this.configs.containsKey(key)) {
//                        change = new ConfigChange(oldValue, (String)null, PropertyChangeType.DELETED);
//                        this.configs.remove(key);
//                    }
//            }
//
//            if (change != null) {
//                this.notifyAll(ImmutableMap.of(key, change));
//            }
//
//        }
    }

    private void notifyAll(Map<String, Object> changes) {
//        this.logger.info("Notfiy config change event: {}", changes);
//        ConfigChangeEvent changeEvent = new ConfigChangeEvent((String)null, changes);
//        Iterator var3 = this.listeners.iterator();
//
//        while(true) {
//            while(var3.hasNext()) {
//                ConfigChangeListener listener = (ConfigChangeListener)var3.next();
//                Set<String> subscribeKey = listener.getSubscribeKeys();
//                Iterator var6 = subscribeKey.iterator();
//
//                while(var6.hasNext()) {
//                    String key = (String)var6.next();
//                    if (changes.containsKey(key)) {
//                        try {
//                            listener.onChange(changeEvent);
//                        } catch (Exception var9) {
//                            this.logger.error(var9.getMessage(), var9);
//                        }
//                        break;
//                    }
//                }
//            }
//
//            return;
//        }
    }

//    public void addListener(ConfigChangeListener listener) {
//        this.listeners.add(listener);
//    }

//    public void removeListener(ConfigChangeListener listener) {
//        this.listeners.remove(listener);
//    }

    public Boolean getBooleanValue(String key) {
        return this.getBooleanValue(key, (Boolean)null);
    }

    public Boolean getBooleanValue(String key, Boolean defaultValue) {
        String value = this.getValue(key, (String)null);
        return value == null ? defaultValue : Boolean.valueOf(value);
    }

    public Integer getIntegerValue(String key) {
        return this.getIntegerValue(key, (Integer)null);
    }

    public Integer getIntegerValue(String key, Integer defaultValue) {
        String value = this.getValue(key, (String)null);
        return value == null ? defaultValue : Integer.valueOf(value);
    }

    public Long getLongValue(String key) {
        return this.getLongValue(key, (Long)null);
    }

    public Long getLongValue(String key, Long defaultValue) {
        String value = this.getValue(key, (String)null);
        return value == null ? defaultValue : Long.valueOf(value);
    }

    public Float getFloatValue(String key) {
        return this.getFloatValue(key, (Float)null);
    }

    public Float getFloatValue(String key, Float defaultValue) {
        String value = this.getValue(key, (String)null);
        return value == null ? defaultValue : Float.valueOf(value);
    }

    public Double getDoubleValue(String key) {
        return this.getDoubleValue(key, (Double)null);
    }

    public Double getDoubleValue(String key, Double defaultValue) {
        String value = this.getValue(key, (String)null);
        return value == null ? defaultValue : Double.valueOf(value);
    }

    public Date getDateValue(String key) throws ParseException {
        return this.getDateValue(key, (Date)null);
    }

    public Date getDateValue(String key, Date defaultValue) throws ParseException {
        String value = this.getValue(key, (String)null);
//        return value == null ? defaultValue : DateUtils.parseDate(value);
        return  new Date();
    }

    public String getValue(String key) {
        return this.getValue(key, (String)null);
    }

    public String getValue(String key, String defaultValue) {
        ConfigEntity config = this.get(key);
        String result = null;
        if (config != null) {
            result = config.getValue();
        }
        return StringUtils.isEmpty(result) ? defaultValue : result;
    }

    public ConfigEntity get(String key) {
        return (ConfigEntity) this.configs.get(key);
    }
}
