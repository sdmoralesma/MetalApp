package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the score_matrix database table.
 * 
 */
@Entity
@Table(name="score_matrix")
public class ScoreMatrix implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_participant")
	private int idParticipant;

	@Column(name="hand_score")
	private float handScore;

	private int hand1;

	private int hand10;

	private int hand2;

	private int hand3;

	private int hand4;

	private int hand5;

	private int hand6;

	private int hand7;

	private int hand8;

	private int hand9;

	@Column(name="head_score")
	private float headScore;

	private int head1;

	private int head10;

	private int head2;

	private int head3;

	private int head4;

	private int head5;

	private int head6;

	private int head7;

	private int head8;

	private int head9;

	@Column(name="total_score")
	private float totalScore;

	//bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name="id_participat")
	private Participant participant;

	public ScoreMatrix() {
	}

	public int getIdParticipant() {
		return this.idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	public float getHandScore() {
		return this.handScore;
	}

	public void setHandScore(float handScore) {
		this.handScore = handScore;
	}

	public int getHand1() {
		return this.hand1;
	}

	public void setHand1(int hand1) {
		this.hand1 = hand1;
	}

	public int getHand10() {
		return this.hand10;
	}

	public void setHand10(int hand10) {
		this.hand10 = hand10;
	}

	public int getHand2() {
		return this.hand2;
	}

	public void setHand2(int hand2) {
		this.hand2 = hand2;
	}

	public int getHand3() {
		return this.hand3;
	}

	public void setHand3(int hand3) {
		this.hand3 = hand3;
	}

	public int getHand4() {
		return this.hand4;
	}

	public void setHand4(int hand4) {
		this.hand4 = hand4;
	}

	public int getHand5() {
		return this.hand5;
	}

	public void setHand5(int hand5) {
		this.hand5 = hand5;
	}

	public int getHand6() {
		return this.hand6;
	}

	public void setHand6(int hand6) {
		this.hand6 = hand6;
	}

	public int getHand7() {
		return this.hand7;
	}

	public void setHand7(int hand7) {
		this.hand7 = hand7;
	}

	public int getHand8() {
		return this.hand8;
	}

	public void setHand8(int hand8) {
		this.hand8 = hand8;
	}

	public int getHand9() {
		return this.hand9;
	}

	public void setHand9(int hand9) {
		this.hand9 = hand9;
	}

	public float getHeadScore() {
		return this.headScore;
	}

	public void setHeadScore(float headScore) {
		this.headScore = headScore;
	}

	public int getHead1() {
		return this.head1;
	}

	public void setHead1(int head1) {
		this.head1 = head1;
	}

	public int getHead10() {
		return this.head10;
	}

	public void setHead10(int head10) {
		this.head10 = head10;
	}

	public int getHead2() {
		return this.head2;
	}

	public void setHead2(int head2) {
		this.head2 = head2;
	}

	public int getHead3() {
		return this.head3;
	}

	public void setHead3(int head3) {
		this.head3 = head3;
	}

	public int getHead4() {
		return this.head4;
	}

	public void setHead4(int head4) {
		this.head4 = head4;
	}

	public int getHead5() {
		return this.head5;
	}

	public void setHead5(int head5) {
		this.head5 = head5;
	}

	public int getHead6() {
		return this.head6;
	}

	public void setHead6(int head6) {
		this.head6 = head6;
	}

	public int getHead7() {
		return this.head7;
	}

	public void setHead7(int head7) {
		this.head7 = head7;
	}

	public int getHead8() {
		return this.head8;
	}

	public void setHead8(int head8) {
		this.head8 = head8;
	}

	public int getHead9() {
		return this.head9;
	}

	public void setHead9(int head9) {
		this.head9 = head9;
	}

	public float getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

}