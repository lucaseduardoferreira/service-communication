package io.github.lucaseduardoferreira.servicecommunication.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Scheduling implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "message_id")
    private Message message;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;

    private LocalDateTime shippingDate;

    @Enumerated(EnumType.STRING)
    private CommunicationType communication;

    private Boolean sent;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
