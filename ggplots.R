library("seqinr")
library("ggplot2")

fasta_AA_reads <- read.fasta(file = "aminoacids.fasta",  seqtype = "AA")
seqid <- names(fasta_AA_reads)

aa_counts<-NULL
for (name in seqid)
  aa_counts<-c(aa_counts,fasta_AA_reads[name][[1]] ) 


# Remove '.'
aa_count_filtered<-as.data.frame(table(aa_counts[!aa_counts %in% c('.')]))

# Set column names
names(aa_count_filtered)<-c("AA", "Counts")

ggplot(data=aa_count_filtered, aes(x=AA, y=Counts)) + geom_bar(stat = "identity", fill="gray30") + theme_minimal() + geom_text(aes(label=Counts),  vjust=-0.3, color="black", size=3.5) +xlab("Amino Acid")

