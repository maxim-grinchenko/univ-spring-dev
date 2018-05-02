package our.spring.dev.com.domain.entity.base;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.Min;
import our.spring.dev.com.infra.serializers.LocalDateDeserializer;
import our.spring.dev.com.infra.serializers.LocalDateSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString

@MappedSuperclass
public abstract class AbstractEntity {
    /**
     * Unique entity identifier
     */
    @Min(value = 1, profiles = "UPDATE")

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}