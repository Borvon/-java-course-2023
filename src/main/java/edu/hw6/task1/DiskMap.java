package edu.hw6.task1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {

    private Path path;

    public DiskMap(Path path) throws IOException {
        this.path = path;

        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
    }

    @Override
    public int size() {
        return Objects.requireNonNull(new File(path.toString()).listFiles()).length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return Files.exists(Paths.get(path.toString(), (String) key));
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public String get(Object key) {
        if (!Files.exists(Paths.get(path.toString(), (String) key))) {
            return null;
        }

        try (RandomAccessFile reader = new RandomAccessFile(Paths.get(path.toString(), (String) key).toString(), "r")) {
            FileChannel channel = reader.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(Math.toIntExact(channel.size()));
            channel.read(buf);
            return new String(buf.array());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String prevValue = get(key);

        try (RandomAccessFile writer = new RandomAccessFile(Paths.get(path.toString(), key).toString(), "rw")) {
            FileChannel channel = writer.getChannel();
            ByteBuffer buf = ByteBuffer.wrap(value.getBytes());
            channel.write(buf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prevValue;
    }

    @Override
    public String remove(Object key) {
        String prevValue = get(key);

        try {
            Files.delete(Paths.get(path.toString(), (String) key));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prevValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        for (var i : m.entrySet()) {
            put(i.getKey(), i.getValue());
        }
    }

    @Override
    public void clear() {
        File[] files = new File(path.toString()).listFiles();

        for (var file : Objects.requireNonNull(files)) {
            file.delete();
        }
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();

        File[] files = new File(path.toString()).listFiles();

        for (var file : Objects.requireNonNull(files)) {
            keys.add(file.getName());
        }

        return keys;
    }

    @NotNull
    @Override
    public Collection<String> values() {
        Set<String> values = new HashSet<>();

        File[] files = new File(path.toString()).listFiles();

        for (var file : Objects.requireNonNull(files)) {
            values.add(get(file.getName()));
        }

        return values;
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        Set<Entry<String, String>> values = new HashSet<>();

        File[] files = new File(path.toString()).listFiles();

        for (var file : Objects.requireNonNull(files)) {
            values.add(Map.entry(file.getName(), get(file.getName())));
        }

        return values;
    }
}
