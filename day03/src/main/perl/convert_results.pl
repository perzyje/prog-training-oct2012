#!/usr/bin/perl
use utf8;
use v5.12;
use strict;
use warnings;
use warnings  qw(FATAL utf8);
use open      qw(:std :utf8);

while (<>) {
	chomp;
	$_ = (split /\t/)[0];
	@_ = split / \x{2192} /;
	if ($_[1] eq 'true') {
		print "assertTrue(warmUp.$_[0]);\n";
	}
	elsif ($_[1] eq 'false') {
		print "assertFalse(warmUp.$_[0]);\n";
	}
	else {
		print "assertEquals($_[1], warmUp.$_[0]);\n";
	}
}
