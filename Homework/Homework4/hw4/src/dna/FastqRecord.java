package dna;

/**
 * A fastq record that contains the defline, sequence, and quality strings from a fastq file
 */
public class FastqRecord implements DNARecord {
    private String defline;
    private String sequence;
    private String quality;

    /**
     * Creates a fastq record with a defline, sequence, and quality string.
     * The defline has to start with '@' or else a RecordFormatException will be thrown
     * @param defline starts with '@' followed by a unique identifier
     * @param sequence string of characters that represent DNA sequence
     * @param quality encodes machine's confidence that corresponding char in sequence is correct
     * @throws RecordFormatException if first character of defline is not '@'
     */
    public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException {
		this.defline = defline;
		this.sequence = sequence;
		this.quality = quality;
    	Character firstCharacter = defline.charAt(0);
    	if (!firstCharacter.equals('@')) {
    		throw new RecordFormatException("Bad first character in defline in fastq record: saw " + firstCharacter
    				+ ", expected @");
    	}
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
     * Checks for deep equality between two FastqRecords
     * @param o an Object
     * @return true if the two fastqRecords are equal and false if not
     */
    @Override
    public boolean equals(Object o) {
        FastqRecord that = (FastqRecord) o;
        return defline.equals(that.defline) &&
                sequence.equals(that.sequence) &&
                quality.equals(that.quality);
    }

    /**
     * Checks for whether the quality of a fastq record is low
     * @return true if the quality contains both "$" and "#" and false if not
     */
    public boolean qualityIsLow() {
        if (quality.contains("$") && quality.contains("#"))
            return true;
        else
        	return false;
    }
    
    /**
     * Returns the sum of the hashcodes of the defline, sequence, and quality strings
     * @return the sum of the hashcodes of the defline, sequence, and quality strings
     */
    public int hashCode() {
        return defline.hashCode() + sequence.hashCode() + quality.hashCode();
    }
}
