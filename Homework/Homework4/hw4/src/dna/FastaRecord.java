package dna;

/**
 * A FastaRecord that has a defline and a sequence string
 * The defline for a FastaRecord starts with a '>'
 */
public class FastaRecord implements DNARecord {
	private String defline;
	private String sequence;

	/**
	 * Creates a FastaRecord with a defline and a sequence string
	 * The defline has to start with '>' or else a RecordFormatException will be thrown
	 * @param defline starts with '>' followed by a unique identifier
	 * @param sequence string of characters that represent DNA sequence
	 * @throws RecordFormatException if first character of defline is not ">"
	 */
	public FastaRecord(String defline, String sequence) throws RecordFormatException {
		this.defline = defline;
		this.sequence = sequence;
		Character firstCharacter = defline.charAt(0);
		if (!firstCharacter.equals(">")) {
			throw new RecordFormatException("Bad first character in defline in fasta record: saw " + firstCharacter
					+ ", expected >");
		}
	}

	/**
	 * Creates a FastaRecord with a defline and a sequence string form a FastqRecord
	 * The first character of the defline in the FastqRecord is replaced with '>'
	 * @param fastqRec the input FastqRecord that will converted into a FastaRecord
	 */
	public FastaRecord(FastqRecord fastqRec) {
		this.defline = ">" + fastqRec.getDefline().substring(1);
		this.sequence = fastqRec.getSequence();
	}

	@Override
	public String getDefline() {
		return defline;
	}

	@Override
	public String getSequence() {
		return sequence;
	}

	/**
	 * Checks for deep equality between two FastaRecords
	 * @param o an Object
	 * @return true if the two FastaRecords are equal and false if not
	 */
	public boolean equals(Object o) {
		FastaRecord that = (FastaRecord) o;
		return defline.equals(that.defline) &&
				sequence.equals(that.sequence);
	}

	/**
	 * Returns the sum of the hashcodes of defline and sequence
	 * @return sum of hashcodes of defline and sequence
	 */
	@Override
	public int hashCode() {
		return defline.hashCode() + sequence.hashCode();
	}
}
